package ex01;






public class Music {
	private String title;
	private String artist;
	private int time;
	private int rating;


	public Music(String title, String artist, int time, int rating) {

		this.title  = title;
		this.artist = artist;
		this.time   = time;
		this.rating = rating;
	}

    public String getTitle() {return this.title;}
    public String getArtist() {return this.artist;}
    public int getTime() {return this.time;}
    public int getRating() {return this.rating;}

    public void play() {
    	System.out.printf("再生中: %s by %s time:%ssec, Rate: %s/5\n",
                this.title, this.artist, this.time, this.rating);
    }

    @Override
    public String toString() {
        return String.format("a Music(%s, %s, %d, %d)\n",
                this.title, this.artist, this.time, this.rating);
    }

	public static void main(String...args) {	//Main ception
      Music music = new Music("なんだこれくしょん", "きゃりーぱみゅぱみゅ", 47, 3);
      System.out.println(music);
      music.play();
	}
}
