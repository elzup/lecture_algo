package ex01;

import java.util.ArrayList;
import java.util.Collections;

public class MusicPlayer {
	private String name;
	private ArrayList<Album>albumList;

	public MusicPlayer(String name) {
		albumList = new ArrayList<Album>();
		this.name = name;
	}

	public void add(Album album) {
		albumList.add(album);
	}

	public void play() {
		System.out.println("全曲再生");
		for(Album al : albumList)
			al.play();
	}

	public void shufflePlay() {
		System.out.println("ランダム再生");
		ArrayList<Music> allMusicList = new ArrayList<Music>();
		for(Album al : albumList)
			allMusicList.addAll(al.getMusicList());
		Collections.shuffle(allMusicList);
		for(Music mu : allMusicList)
			mu.play();
	}

	public static void main(String...args) {
		MusicPlayer mp = new MusicPlayer("iphone");

// datas{{{
    	String title = "jacaranda";
    	String artist = "tacica";
    	Album album = new Album(title, artist);
        album.add(new Music("20日鼠とエンドロール", artist, 147, 3));
        album.add(new Music("鼈甲の手"            , artist, 222, 3));
        album.add(new Music("アトリエ"            , artist, 247, 5));
        album.add(new Music("人鳥哀歌"            , artist, 240, 5));
        album.add(new Music("タイル"              , artist, 248, 5));
        album.add(new Music("某鬣犬"              , artist, 202, 3));
        album.add(new Music("ジャッカロープ"      , artist, 306, 3));
        album.add(new Music("蜜蜂の毛皮"          , artist, 258, 3));
        album.add(new Music("Galapagos"           , artist, 182, 3));
        album.add(new Music("メトロ"              , artist, 290, 5));
        album.add(new Music("γ"                  , artist, 300, 4));
        mp.add(album);

    	title = "Awa Come";
    	artist = "チャットモンチー";
    	album = null;
    	album = new Album(title, artist);
        album.add(new Music("ここだけの話"      , artist, 201, 5));
        album.add(new Music("キャラメルプリン"  , artist, 228, 5));
        album.add(new Music("青春の一番礼所"    , artist, 176, 4));
        album.add(new Music("雲走る"            , artist, 268, 3));
        album.add(new Music("あいかわらず"      , artist, 248, 5));
        album.add(new Music("セカンドプレゼント", artist, 216, 3));
        album.add(new Music("My Suger View"     , artist, 277, 3));
        album.add(new Music("また、近いうちに"  , artist,  95, 5));
        mp.add(album);

    	title = "感情エフェクト";
    	artist = "ONE OK ROCK";
    	album = null;
    	album = new Album(title, artist);
        album.add(new Music("恋ノアイボウ心ノクピド", artist, 174, 5));
        album.add(new Music("どっぺるゲンガー"      , artist, 220, 4));
        album.add(new Music("皆無"                  , artist, 220, 5));
        album.add(new Music("20 years old"          , artist, 233, 5));
        album.add(new Music("Living Dolls"          , artist, 240, 3));
        album.add(new Music("Break My Strings"      , artist, 248, 3));
        album.add(new Music("存在証明"              , artist, 193, 4));
        album.add(new Music("CONVINCING"            , artist, 221, 4));
        album.add(new Music("My sweet baby"         , artist, 295, 3));
        album.add(new Music("Reflection"            , artist, 218, 3));
        album.add(new Music("Viva Violent Fellow"   , artist, 216, 3));
        album.add(new Music("JUST"                  , artist, 195, 4));
        mp.add(album);
// ms -end}}}

        mp.play();
        mp.shufflePlay();
	}
}

