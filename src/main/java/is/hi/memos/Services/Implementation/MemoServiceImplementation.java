package is.hi.memos.Services.Implementation;

import is.hi.memos.Persistence.Entities.Memo;
import is.hi.memos.Persistence.Repositories.MemoRepository;
import is.hi.memos.Services.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoServiceImplementation implements MemoService {

    private MemoRepository memoRepository;

    @Autowired
    public MemoServiceImplementation(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    @Override
    public Memo save(Memo memo) {
        return memoRepository.save(memo);
    }

    @Override
    public void delete(Memo memo) {
        memoRepository.delete(memo);
    }

    @Override
    public List<Memo> findAll() {
        return memoRepository.findAll();
    }

    @Override
    public List<Memo> findByMemoTitle(String memoTitle) {
        return memoRepository.findByMemoTitle(memoTitle);
    }

    @Override
    public Memo findByID(long ID) {
        return memoRepository.findByID(ID);
    }
}
