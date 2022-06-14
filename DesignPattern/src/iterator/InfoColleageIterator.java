package iterator;

import java.util.Iterator;
import java.util.List;

public class InfoColleageIterator implements Iterator {


    List<Department> departmentList; // 信息工程学院是以List方式存放系

    public InfoColleageIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
    int index = -1;//索引

    @Override
    public boolean hasNext() {
       if(index>=departmentList.size()-1){
           return false;
       }else {
           index+=1;
           return true;
       }
    }

    @Override
    public Object next() {
        return departmentList.get(index).toString();
    }

    @Override
    public void remove() {

    }
}
