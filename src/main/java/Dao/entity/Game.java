package Dao.entity;

public class Game {
    private int id;
    private String game_title;
    private String game_type;

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", game_title='" + game_title + '\'' +
                ", game_type='" + game_type + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGame_title() {
        return game_title;
    }

    public void setGame_title(String game_title) {
        this.game_title = game_title;
    }

    public String getGame_type() {
        return game_type;
    }

    public void setGame_type(String game_type) {
        this.game_type = game_type;
    }
}
