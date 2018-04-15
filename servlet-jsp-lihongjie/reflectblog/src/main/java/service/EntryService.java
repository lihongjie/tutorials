package service;

import bean.Entry;
import vo.EntryVo;

import java.util.List;

public interface EntryService {
    //创建文章
    public boolean addEntry(Entry entry);

    //
    public List<Entry> listEntry();

    //修改文章操作
    public boolean editEntry(Entry entry);

    //删除文章操作
    public boolean deleteEntry(Entry entry);

    //通过id找到文章
    public Entry findById(Object id);

    public List<EntryVo> listEntryVo();
}