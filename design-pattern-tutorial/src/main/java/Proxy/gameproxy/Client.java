package Proxy.gameproxy;

public class Client {
	public static void main(String[] args) {
		GamePlayer game = new GamePlayer("����");
		game.login("aa", "123456");
		game.killBoss();
		game.upgrade();
	}
}
