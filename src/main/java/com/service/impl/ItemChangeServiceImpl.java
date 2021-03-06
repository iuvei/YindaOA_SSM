package com.service.impl;

import com.dao.YoItemChangeMapper;
import com.model.YoItemChange;
import com.model.YoItemChangeExample;
import com.service.IItemChangeExcelService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 队标：一篇代码，最好不要超过200行，尽量不要超过300行，一定不能超过500行
 */
@Service
public class ItemChangeServiceImpl implements IItemChangeExcelService {

    @Autowired
    public YoItemChangeMapper yoItemChangeMapper;

    /**
     * 该方法实现对表头的校验，至于剩余内容的校验，在插入方法中完成
     * 表头不符合规范或者发生了空指针异常，皆视为校验失败
     */
    public String validateExcelTitle(String fileDir) throws IOException {
        File file = new File(fileDir);
        InputStream inputStream = new FileInputStream(file);
        // Java的规定，有了输入流才能按照格式读取excel文件
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        // 得到当前文件的总表数
        int sheetTotal = hssfWorkbook.getNumberOfSheets();

        // 接下来对每一张表都进行操作
        for (int sheetNo=0; sheetNo<sheetTotal; sheetNo++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetNo);
            // 在表头校验方法中，我们只玩第一行！
            HSSFRow hssfRow = hssfSheet.getRow(0);
            try {
                // int也是一个对象，大括号结束后会释放掉
                int cellNo = 0;
                // 这里用一个大胆的做法，先执行函数再自加。虽然++i听说效率更高，但想必也高不到哪里去
                if (hssfRow.getCell(cellNo++).toString().equals("审批编号")
                        && hssfRow.getCell(cellNo++).toString().equals("标题")
                        && hssfRow.getCell(cellNo++).toString().equals("审批状态")
                        && hssfRow.getCell(cellNo++).toString().equals("审批结果")
                        && hssfRow.getCell(cellNo++).toString().equals("审批发起时间")
                        && hssfRow.getCell(cellNo++).toString().equals("审批完成时间")
                        && hssfRow.getCell(cellNo++).toString().equals("发起人工号")
                        && hssfRow.getCell(cellNo++).toString().equals("发起人姓名")
                        && hssfRow.getCell(cellNo++).toString().equals("发起人部门")
                        && hssfRow.getCell(cellNo++).toString().equals("历史审批人姓名")
                        && hssfRow.getCell(cellNo++).toString().equals("审批记录")
                        && hssfRow.getCell(cellNo++).toString().equals("当前处理人姓名")
                        && hssfRow.getCell(cellNo++).toString().equals("审批耗时")
                        && hssfRow.getCell(cellNo++).toString().equals("变动部门")
                        && hssfRow.getCell(cellNo++).toString().equals("变动项目")
                        && hssfRow.getCell(cellNo++).toString().equals("变动订单")
                        && hssfRow.getCell(cellNo++).toString().equals("变动省份")
                        && hssfRow.getCell(cellNo++).toString().equals("变动城市")
                        && hssfRow.getCell(cellNo++).toString().equals("室外工作")
                        && hssfRow.getCell(cellNo++).toString().equals("生效日期")
                        ) {
                    // 如果验证通过了，就打印成功信息（额，要不然什么都不做的话显得不太好= =）
                    // sheetNo+1必须用括号括起来，否则+1会被认为是字符串拼接，在此再次感叹Java语法的强大！
                    System.out.println("表头校验成功！通过校验的表格页数 = "+(sheetNo+1));
                }
                else {
                    return "表头名称错误，与模板不相符";
                }
            } catch (NullPointerException e) {
                return "表头名称错误，与模板不相符";
            }
        }

        return "表头校验成功！";
    }

    /**
     * 循环地操作excel中的每一行数据
     * 如果审批编号相同，就更新数据，如果为新数据则插入
     * 为了方便，暂时将Map的格式统一为String+Object
     */
    public Map<String, Object> insertAndUpdate(String fileDir) throws IOException {
        Map<String, Object> mapInsert = new HashMap<String, Object>();
        List<YoItemChange> listFail = new ArrayList<YoItemChange>();

        File file = new File(fileDir);
        InputStream inputStream = new FileInputStream(file);
        // Java的规定，有了输入流才能按照格式读取excel文件
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        // 得到当前文件的总表数
        int sheetTotal = hssfWorkbook.getNumberOfSheets();

        // 设定一个变量，记录for循环当中操作成功的条目数目
        int successAmount = 0;
        // 接下来对每一张表都进行操作
        for (int sheetNo=0; sheetNo<sheetTotal; sheetNo++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetNo);
            // 这里不要用物理行数，要用最后一行的编号，不然很容易跳坑
            int rowLastNo = hssfSheet.getLastRowNum();

            // 从第二行开始，对每一张表中的每一行进行操作
            for (int rowNo=1; rowNo<=rowLastNo; rowNo++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNo);
                // 同理，这里也不要用单元格的总数，要用最后一个单元格的序号
                int cellLastNo = hssfRow.getLastCellNum();

                /*
                现在开始做真正的功能！
                第一步，把得到的hssfRow对象中的每一个cell都设为文本类型，确保每一个整形数值在toString后不会自动加上.0
                */
                for (int cellNo=0; cellNo<=cellLastNo; cellNo++) {
                    // cell不为空时才操作，为空也就不用管他是什么类型了
                    // 想管也管不起，因为会报NullPointerException，而我们编程时应当避免异常，而不是积极处理异常
                    if (hssfRow.getCell(cellNo) != null) hssfRow.getCell(cellNo).setCellType(1);
                }

                /*
                第二步，检查当前行是不是空行，如果是就跳过后面的，操作下一行
                检查方法：空的单元格的数目是否等于最后单元格序号+1
                 */
                int emptyCellAmount = 0;
                for (int cellNo=0; cellNo<=cellLastNo; cellNo++) {
                    // cell不为空时才操作，为空也就不用管他是什么类型了
                    // 想管也管不起，因为会报NullPointerException，而我们编程时应当避免异常，而不是积极处理异常
                    if (hssfRow.getCell(cellNo)==null || hssfRow.getCell(cellNo).equals("")) {
                        // 这里就可以用++i了，听说运算速度更快= =
                        ++emptyCellAmount;
                    }
                }
                if (emptyCellAmount == cellLastNo+1) continue;

                /*
                第三步，对于不为空的行，将数据注入引用过来的实体对象
                在完成后面的函数之后，再对变量自加，方便下一行的判断。再玩一把火！
                 */
                int cellNo = -1;
                YoItemChange yoItemChange = new YoItemChange();
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcApproveNo(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcTitle(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcApproveState(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcApproveResult(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcApproveBegin(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcApproveEnd(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcAskStaffId(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcAskStaffName(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcAskStaffDepart(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcHistoryApproveName(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcApproveRecord(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcNowApproveName(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcCost(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcDepartment(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcChangeItem(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcChangeOrder(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcChangeProvince(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcWorkCity(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcOutroomWork(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null) yoItemChange.setIcEffectDate(hssfRow.getCell(cellNo).toString());

                if (hssfRow.getCell(0) == null) {
                    listFail.add(yoItemChange);
                    continue;
                }

                /*
                第四步，检查数据库中是否有相同的审批编号，如果没有，说明是一个新的条目，执行插入操作
                之所以有失败的可能性，是因为单元格内容有可能超过数据库长度
                 */
                String approveNo = hssfRow.getCell(0).toString();
                YoItemChangeExample yoItemChangeExample = new YoItemChangeExample();
                yoItemChangeExample.createCriteria().andIcApproveNoEqualTo(approveNo);
                List<YoItemChange> listExist = yoItemChangeMapper.selectByExample(yoItemChangeExample);

                if (listExist.size() == 0) {
                    try {
                        yoItemChangeMapper.insert(yoItemChange);
                    } catch (Exception e) {
                        listFail.add(yoItemChange);
                        continue;
                    }
                }
                /*
                第五步，如果有相同的编号，说明数据库中有元数据
                那么，就覆盖查询到的第一条数据
                同样，也有失败的可能性
                 */
                else {
                    int sequenceNo = listExist.get(0).getIcSequenceNo();
                    yoItemChange.setIcSequenceNo(sequenceNo);
                    try {
                        yoItemChangeMapper.updateByPrimaryKey(yoItemChange);
                    } catch (Exception e) {
                        listFail.add(yoItemChange);
                        continue;
                    }
                }

                // 到了这一步，说明插入或更新成功，数目自加！
                successAmount++;
            }
        }

        // for循环之后，把成功数目和失败列表返回到map
        mapInsert.put("successAmount", successAmount);
        mapInsert.put("listFail", listFail);
        System.out.println("successAmount = "+successAmount);
        System.out.println("listFail.size() = "+listFail.size());
        return mapInsert;
    }

}
