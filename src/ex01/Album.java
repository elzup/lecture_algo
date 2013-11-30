package ex01;

import java.util.ArrayList;

public class Album {
    private String title;
    private String artist;
    private ArrayList<Music> musicList;

    public Album(String title, String artist) {
        musicList = new ArrayList<Music>();
        this.title  = title;
        this.artist= artist;
    }

    public String getTitle() { return this.title; }
    public String getArtist() { return this.artist; }
    public ArrayList<Music> getMusicList() {
        return this.musicList;
    }

    public void add(Music music) {
        musicList.add(music);
    }

    public int getTotalTime() {
        int sum = 0;
        for(Music m:this.musicList) sum+= m.getTime();
        return sum;
    }

    public double getRating() {
        int sum = 0;
        for(Music m:this.musicList) sum+= m.getRating();
        return (float)sum / this.musicList.size();
    }

    public void play() {
    	System.out.printf("アルバム再生中: %s by %s (%s曲, %ssec. 評価: %s\n",
    			this.title, this.artist, this.musicList.size(), this.getTotalTime(), this.getRating());
        for(Music m:this.musicList) m.play();
        System.out.println("再生終了");
    }

    @Override
    public String toString() {
        return String.format("a Album(%s, %s, %s, %s, %s)\n",
                this.title, this.artist, this.musicList.size(), this.getTotalTime(), this.getRating());
    }


    public static void main(String...args) {
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

        System.out.println(album);
        System.out.println("総再生時間: " + album.getTotalTime());
        System.out.println("アルバム評価:: " + album.getRating());
        album.play();
    }
}
