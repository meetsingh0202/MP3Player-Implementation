import java.util.*;

class Playlist{
    static HashMap<String, ArrayList<Song>> track;
    String playlistName;
    String playlistGenre;
    ArrayList<Song> songs = new ArrayList<Song>();
    int currPlaylistSong = 0;
    Song currentSong;
    Playlist(String name, String genre, HashMap<String, ArrayList<Song>> tracks){
        playlistName = name;
        playlistGenre = genre;
        track = tracks;
        addSongs(playlistGenre);
        currentSong = songs.get(currPlaylistSong);
    }

    void addSongs(String genre){
        for(Song tempSong : track.get(genre)){
            songs.add(tempSong);
        }
    }
    
    void getCurrSong(){
        currentSong.getSongName();
    }

    void playNextSong(){
        if (currPlaylistSong < songs.size()){
            System.out.println("Playing Next Song");
            songs.get(currPlaylistSong).getSongName();
            currPlaylistSong += 1;
        }
        else{
            System.out.println("Playlist Exhausted");
            System.out.println("Playing Playlist Again");
            currPlaylistSong = 0;
            currentSong = songs.get(currPlaylistSong);
        }
    }

    void getNextSongInPlaylist(){
        System.out.print("Next Song In Playlist : ");
        songs.get(currPlaylistSong + 1).getSongName();
    }

    void getplaylistName(){
        System.out.println("Playlist Name : " + playlistName);
    }
}

class Song{
    String currSong;
    String currArtist;
    String currGenre;
    
    Song(String name, String artist, String genre){
        currSong = name;
        currArtist = artist;
        currGenre = genre;
    }
    void getSongName(){
        System.out.println("SongName : " + currSong);
    }
    void getSongArtist(){
        System.out.println("SongName : " + currArtist);
    }
    void getSongGenre(){
        System.out.println("SongName : " + currGenre);
    }
}

class Mp3Player{

    HashMap<String, ArrayList<Song>> track = new HashMap<String, ArrayList<Song>>();    
    Playlist HappyPlaylist;
    Playlist SadPlaylist;
    Playlist DefaultPlaylist;
    Playlist DancePlaylist;

    Mp3Player(){
        GenerateSong();
        GeneratePlaylists();
    }

    void GenerateSong(){
        Song s1 = new Song("Sun Is Shining", "Bob Marley", "Happy");
        Song s2 = new Song("I Get Around", "The Beach Boys", "Happy");
        Song s3 = new Song("September", "Earth, Wind & Fire", "Happy");
        Song s4 = new Song("House of Fun", "Madness", "Happy");
        Song s5 = new Song("In The Stars", "Benson Boone", "Sad");
        Song s6 = new Song("The Luckiest", "Ben Folds", "Sad");
        Song s7 = new Song("Easy on Me", "Adele", "Sad");
        Song s8 = new Song("Birthday Cake", "Justin", "Sad");
        Song s9 = new Song("On The Floor", "Jennifer Lopez", "Dance");
        Song s10 = new Song("I Gotta Feeling", "Black Eyed Peas", "Dance");

        ArrayList<Song> HappySongs = new ArrayList<Song>();
        ArrayList<Song> SadSongs = new ArrayList<Song>();
        ArrayList<Song> DefaultSongs = new ArrayList<Song>();
        ArrayList<Song> DanceSongs = new ArrayList<Song>();
        HappySongs.add(s1);
        HappySongs.add(s2);
        HappySongs.add(s3);
        HappySongs.add(s4);
        SadSongs.add(s5);
        SadSongs.add(s6);
        SadSongs.add(s7);
        SadSongs.add(s8);
        DanceSongs.add(s9);
        DanceSongs.add(s10);
        DefaultSongs.add(s1);
        DefaultSongs.add(s2);
        DefaultSongs.add(s3);
        DefaultSongs.add(s4);
        DefaultSongs.add(s5);
        DefaultSongs.add(s6);
        DefaultSongs.add(s7);
        DefaultSongs.add(s8);
        DefaultSongs.add(s9);
        DefaultSongs.add(s10);
        track.put("Happy", HappySongs);
        track.put("Sad", SadSongs);
        track.put("Default", DefaultSongs);
        track.put("Dance", DanceSongs);
    }

    void GeneratePlaylists(){       
        HappyPlaylist = new Playlist("Happy Playlist", "Happy", track);
        SadPlaylist = new Playlist("Sad Playlist", "Sad", track);
        DefaultPlaylist = new Playlist("Default Playlist", "Default", track);
        DancePlaylist = new Playlist("Dance Playlist", "Dance", track);
    }

    String currState = "OFF";
    boolean paused = false;
    Playlist currPlaylist;

    void getCurrentSong(){
        currPlaylist.getCurrSong();
    }
    
    void getCurrentArtist(){
        currPlaylist.currentSong.getSongArtist();
    }
    
    void getCurrentPlaylist(){
        currPlaylist.getplaylistName();
    }

    void getnextSongInQueue(){
        currPlaylist.getNextSongInPlaylist();
    }
    
    void PlayPlaylist(String playlistName){
        if (track.containsKey(playlistName)){

            System.out.print("Started Playing : ");

            if (playlistName == "Happy"){
                currPlaylist = HappyPlaylist;
            }
            else if (playlistName == "Sad"){
                currPlaylist = SadPlaylist;
            }
            else if (playlistName == "Dance"){
                currPlaylist = DancePlaylist;
            }
        }
        else{
            System.out.print("Playlist Not Found Hence, Started Playing : ");
            currPlaylist = DefaultPlaylist;
        }
        currPlaylist.getplaylistName();
        currState = "ON";
    }

    void Play(){
        if (currState == "ON"){
            System.out.println("Already playing");
        }
        else{
            currState = "ON";
            if (paused == true){
                System.out.println("Resumed Playing");
            }
            else{
                currPlaylist = DefaultPlaylist;
                System.out.println("Started Playing");
            }
        }
    }

    void Stop(){
        if (currState == "ON"){
            System.out.println("Stopped Playing");
            paused = false;
            currState = "OFF";
            currPlaylist = null;
        }
        else{
            System.out.println("Invalid Command");
        }
    }

    void Pause(){
        if (currState == "ON"){
            System.out.println("Paused Playing");
            paused = true;
            currState = "OFF";
        }
        else{
            System.out.println("Invalid Command");
        }
    }

    void playNext(){
        currPlaylist.playNextSong();
    }
}

class Mp3PlayerManager{
    public static void main(String[] args){
        Mp3Player player = new Mp3Player();
        // player.Play();
        // player.getCurrentSong();
        // player.getCurrentArtist();
        // player.getnextSongInQueue();
        // player.getCurrentPlaylist();
        // player.Pause();
        // player.Play();
        // player.Stop();
        // player.PlayPlaylist("Happy");
        // player.playNext();
        // player.playNext();
        // player.playNext();
        // player.playNext();
        // player.playNext();
        // player.playNext();
    }
}
