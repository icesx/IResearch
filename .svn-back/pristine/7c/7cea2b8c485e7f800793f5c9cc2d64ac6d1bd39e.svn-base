package cn.i.xportal.jdp.chainofresp;

public abstract class Handler {
	protected Handler handler;

	public abstract void handleRequest();

	public  void handleNext() {
		handleRequest();
		if(handler!=null){
			handler.handleNext();
		}		
	}

	public void setHandler(Handler successor) {
		this.handler = successor;
	}

}
