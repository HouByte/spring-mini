package cn.meshed.framework.test.bean;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class BookService {

    private String bookName;

    public BookService(String bookName) {
        this.bookName = bookName;
    }

    public void queryBookInfo(){
        System.out.println("查询书籍信息"+bookName);
    }
}
