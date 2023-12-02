//package com.atguigu.spzx.manager.test;
//
//import com.alibaba.excel.EasyExcel;
//import com.atguigu.spzx.manager.listener.ExcelListener;
//import com.atguigu.spzx.model.vo.product.CategoryExcelVo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class EasyExcelTest {
//
//    public static void main(String[] args) {
////        readDateToExcel();
//        writeDataToExcel();
//    }
//
//    //读取方法
//    public static void readDateToExcel() {
//        String fileName = "E:\\java学习资料\\尚硅谷\\10.实战项目\\4.尚硅谷全套JAVA教程—实战项目（71.89GB）\\尚硅谷-尚品甄选项目\\资料\\01.xlsx";
//        // 创建一个监听器对象
//        ExcelListener<CategoryExcelVo> listener = new ExcelListener<>();
//        // 解析表格
//        EasyExcel.read(fileName, CategoryExcelVo.class, listener).sheet().doRead();
//        //获取解析到的数据
//        List<CategoryExcelVo> excelVoList = listener.getDatas();
//        // 进行遍历操作
//        excelVoList.forEach(System.out::println);
//    }
//
//    public static void writeDataToExcel() {
//        List<CategoryExcelVo> list = new ArrayList<>() ;
//        list.add(new CategoryExcelVo(1L , "数码办公" , "",0L, 1, 1)) ;
//        list.add(new CategoryExcelVo(11L , "华为手机" , "",1L, 1, 2)) ;
//        EasyExcel.write("E:\\java学习资料\\尚硅谷\\10.实战项目\\4.尚硅谷全套JAVA教程—实战项目（71.89GB）\\尚硅谷-尚品甄选项目\\资料\\01.xlsx" , CategoryExcelVo.class).sheet("分类数据1").doWrite(list);
//    }
//}
