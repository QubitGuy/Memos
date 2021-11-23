package is.hi.memos.Persistence.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Memo")
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(name = "memoTitle")
    private String memoTitle;
    @Column(name = "memoText")
    private String memoText;
    @Column(name = "date")
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Memo memo;

    @OneToMany(mappedBy = "memo", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Memo> memos = new ArrayList<>();

    public Memo(){
    }

    public Memo(long ID, String memoTitle, String memoText, String date) {
        this.ID = ID;
        this.memoTitle = memoTitle;
        this.memoText = memoText;
        this.date = date;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getMemoTitle() {
        return memoTitle;
    }

    public void setMemoTitle(String memoTitle) {
        this.memoTitle = memoTitle;
    }

    public String getMemoText() {
        return memoText;
    }

    public void setMemoText(String memoText) {
        this.memoText = memoText;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Memo> getMemos() {
        return memos;
    }

    public void setMemos(List<Memo> memos) {
        this.memos = memos;
    }
}
