package project.pro.paging;

import lombok.Data;

@Data
public class Paging {
    private int nowPage;
    private int startPage;
    private int endPage;
    private int total;
    private int cntPerPage;
    private int lastPage;
    private int start;
    private int end;
    private int cntPage = 10;


    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCntPerPage() {
        return cntPerPage;
    }

    public void setCntPerPage(int cntPerPage) {
        this.cntPerPage = cntPerPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getCntPage() {
        return cntPage;
    }

    public void setCntPage(int cntPage) {
        this.cntPage = cntPage;
    }

    @Override
    public String toString() {
        return "Paging{" +
                "nowPage=" + nowPage +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", total=" + total +
                ", cntPerPage=" + cntPerPage +
                ", lastPage=" + lastPage +
                ", start=" + start +
                ", end=" + end +
                ", cntPage=" + cntPage +
                '}';
    }



    public Paging(int total, int nowPage, int cntPerPage ){
        this.nowPage = nowPage;
        calcLastPage(total, cntPerPage);
        startEndPage(nowPage, cntPage);

        System.out.println(cntPage);

    }

    public void calcLastPage(int total, int cntPerPage){
        lastPage=(total/cntPerPage);
        if (total%cntPerPage != 0){
            lastPage=((total/cntPerPage)+1);

        }
    }

    public void startEndPage(int nowPage, int cntPage){
        /*setEndPage(((int)Math.ceil((double)nowPage / cntPage)) * cntPage);
        setStartPage(getEndPage() - cntPage + 1);*/


        startPage = nowPage / cntPage * cntPage + 1;
        if(nowPage % cntPage == 0) {
            startPage -= cntPage;
        }


        endPage = startPage + cntPage - 1 ;
        if(endPage > lastPage) {
            endPage = lastPage;
        }
    }
}
