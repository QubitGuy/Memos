package is.hi.memos.Services;

import is.hi.memos.Persistence.Entities.Memo;

import java.util.List;

public interface MemoService {
    Memo save(Memo memo);
    void delete(Memo memo);
    List<Memo> findAll();
    List<Memo> findByMemoTitle(String memoTitle);
    Memo findByID(long ID);
}
