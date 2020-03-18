package Proxy.gameproxy;

public class GamePlayerProxy implements IGamePlayer {
	

	
	private IGamePlayer gameplayer = null; 

	public GamePlayerProxy(String name) {
		try{
			gameplayer = new GamePlayer(name);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void login(String username, String password) {
		this.gameplayer.login(username, password);
	}

	@Override
	public void killBoss() {
		this.gameplayer.killBoss();
	}

	@Override
	public void upgrade() {
		this.gameplayer.upgrade();
	}

}
