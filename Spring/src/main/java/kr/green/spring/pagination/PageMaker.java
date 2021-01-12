package kr.green.spring.pagination;
// 현재 활성화된 페이지가 포함된 페이지들을 나타내는 클래스
public class PageMaker {
	private int totalCount;		// 총 개시글 수 - 마지막 페이지의 끝 페이지 번호
	private int startPage;		// 현재 활성화된 페이지를 포함하는 페이지들의 시작페이지
	private int endPage;		// 현재 활성화된 페이지를 포함하는 페이지들의 마지막페이지
	private boolean prev;
	private boolean next;
	private int displayPageNum;	// 한 페이지메이커가 보여줄 페이지의 갯수
	private Criteria criteria;	// 현재 페이지 정보
	
	public PageMaker(Criteria cri, int displayPageNum, int totalCount) {
		this.criteria = cri;
		this.displayPageNum = displayPageNum;
		this.setTotalCount(totalCount);		// 생성자 호출하면서 calcData() 호출
	}
	
	/* endPage, startPage, prev, next 값 계산 */
	public void calcData() {
		/* starPage와 endPage는 현재 페이지 정보인 criteria와 displayPageNum을 이용하여 계산
		 * displayPageNum이 10이고 현재 페이지가 3페이지면 startPage = 1, endPage = 10이 되도록 계산 */
		endPage = (int) (Math.ceil(criteria.getPage()/(double) displayPageNum)*displayPageNum);
		
		startPage = (endPage - displayPageNum)+1;
		/* 총 콘텐츠 갯수를 이용하여 마지막 페이지 번호를 계산 */
		int tempEndPage = (int)(Math.ceil(totalCount/(double)criteria.getPerPageNum()));
		
		/* 현재 페이지에 계산된 현재 페이지메이커의 마지막 페이지 번호와 실제 마지막 페이지 번호를 비교하여
		 * 작은 값이 마지막 페이지 번호가 됨 */
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		/* 현재 페이지메이커에 시작페이지가 1페이지면 prev가 없어야 함 */
		prev = startPage == 1 ? false : true;
		/* 현재 페이지메이커에 마지막 페이지에 컨텐츠의 마지막이 포함되어 있으면 next가 없어야 함 */
		next = endPage * criteria.getPerPageNum() >= totalCount ? false:true;
	}
	/* getter and setter */
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {		
		this.totalCount = totalCount;
		calcData();						
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
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	public Criteria getCriteria() {
		return criteria;
	}
	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", criteria=" + criteria + "]";
	}
}
