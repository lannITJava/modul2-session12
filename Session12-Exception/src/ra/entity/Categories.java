package ra.entity;

import ra.IShop;

import java.util.List;
import java.util.Scanner;

public class Categories implements IShop {
    private int catalogId;
    private String catalogName;
    private boolean status;

    public Categories() {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.status = status;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner, List<Categories> categoriesList, List<Product> productList) {
        System.out.println("Nhập vào mã danh mục sản phẩm");
        boolean checkCatalogId= true;
        do {
            try{
                this.catalogId= Integer.parseInt(scanner.nextLine());
                if (this.catalogId>0){
                    boolean isExit = false;
                    for (Categories catalog: categoriesList) {
                        if (catalog.catalogId==this.catalogId){
                            isExit = true;
                            break;
                        }
                    }
                    if (isExit){
                        System.err.println("Mã danh mục sản phẩm đã tồn tại, vui lòng nhập lại");
                    }else {
                        break;
                    }
                }else {
                    System.err.println("Mã danh mục phải lớn hơn 0, vui lòng nhập lại");
                }
            }catch (NumberFormatException ex){
                System.err.println("Mã danh mục phải là số nguyên, vui lòng nhập lại");
            }
        }while (checkCatalogId);
        System.out.println("Nhập vào tên danh mục sản phẩm");
        boolean checkCatalogName = true;
        do {
            this.catalogName= scanner.nextLine();
            boolean isExit = false;
            for (Categories catalog: categoriesList) {
                if (catalog.catalogName.equals(this.catalogName)){
                    isExit = true;
                    break;
                }
            }
            if (isExit){
                System.err.println("Tên danh mục sản phẩm đã tồn tại, vui lòng nhập lại");
            }else {
                break;
            }
        }while (checkCatalogName);
        System.out.println("Nhập vào trạng thái danh mục: ");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Mã danh mục: %d - Tên danh mục: %s - Trạng thái danh mục: %b\n",this.catalogId,this.catalogName,this.status);
    }
}
