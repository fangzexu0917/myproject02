package com.projectmanagement.view;

import com.projectmanagement.bean.Customer;
import com.projectmanagement.service.CustomerList;
import com.projectmanagement.util.CMUtility;

/**
 * CustomerView为主模块，负责菜单的显示和处理用户操作
 */
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("方泽旭",'男',23,"18768080956","870535620@qq.com");
        customerList.addCustomer(customer);
    }

    public void enterMainMenu() {
        boolean isFlag = true;
        do {
            System.out.println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退      出\n");
            System.out.print("      请选择(1-5)：");
            char selection = CMUtility.readMenuSelection();

            switch (selection) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.printf("确认是否退出(Y/N): ");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
            }
        } while (isFlag);
    }

    /**
     * 添加客户
     */
    private void addNewCustomer() {
        System.out.println("---------------------添加客户---------------------");
        System.out.println("姓名：");
        String name = CMUtility.readString(20);
        System.out.println("性别：");
        char gender = CMUtility.readChar();
        System.out.println("年龄：");
        int age = CMUtility.readInt();
        System.out.println("电话：");
        String tel = CMUtility.readString(13);
        System.out.println("邮箱：");
        String email = CMUtility.readString(40);
        Customer customer = new Customer(name, gender, age, tel, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if(isSuccess){
            System.out.println("---------------------添加完成---------------------");
        }else{
            System.out.println("------------------客户目录已满，添加失败------------------");
        }
    }

    /**
     * 修改客户
     */
    private void modifyCustomer() {

    }

    /**
     * 删除客户
     */
    private void deleteCustomer() {

    }

    /**
     * 客户列表
     */
    private void listAllCustomers() {
        System.out.println("-----------------客户列表-----------------");

        Customer[] custs = customerList.getAllCustomers();
        if (custs.length == 0) {
            System.out.println("\t\t\t没有任何客户记录!");
        } else {
            System.out.println("编号\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱");
            for (int i = 0; i < custs.length; i++) {
                Customer cust = custs[i];
                System.out.println((i + 1) +"\t"+ cust.info());
            }
        }
        System.out.println("----------------客户列表完成---------------");

    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }


}
