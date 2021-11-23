package is.hi.memos.Persistence.Repositories;

import is.hi.memos.Persistence.Entities.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    Memo save(Memo memo);
    void delete(Memo memo);
    List<Memo> findAll();
    List<Memo> findByMemoTitle(String memoTitle);
    Memo findByID(long ID);
}
