package Proxy.gameproxy;

public class GamePlayer implements IGamePlayer {
	
	private String name = "";
	

	public GamePlayer(String _name) {
		this.name = _name;
	}

	@Override
	public void login(String username, String password) {
		System.out.println("��½��Ϊ��"+username+" ���û� "+ this.name+"��½�ɹ���");
	}

	@Override
	public void killBoss() {
		System.out.println(this.name+"�ڴ�֣�");
	}

	@Override
	public void upgrade() {
		System.out.println(this.name+"��������");

	}

}
