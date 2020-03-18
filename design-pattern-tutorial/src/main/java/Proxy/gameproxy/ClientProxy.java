package Proxy.gameproxy;

public class ClientProxy {
	public static void main(String[] args) {
		GamePlayer gamePlayer = new GamePlayer("����");
//		GamePlayerProxy gameProxy = new GamePlayerProxy(gamePlayer);
		GamePlayerProxy gameProxy = new GamePlayerProxy("����");
		System.out.println("------------------");
		gameProxy.login("zhangsan", "123456");
		gameProxy.killBoss();
		gameProxy.upgrade();
		System.out.println("-------------------");
	}
}
