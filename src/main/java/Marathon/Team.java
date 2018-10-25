package Marathon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Team {
    private String name;
    private Competitor[] participants;

    public void showResults(){
        System.out.println("Список всех участников команды \"" + name + "\":");
        for (Competitor competitor: this.participants){
            competitor.info();
        }
    }

    public void showWhoPassedDistance(){
        System.out.println("Список участников команды \"" + name + "\", прошедших дистанцию:");
        for (Competitor competitor: this.participants){
            if (competitor.isOnDistance()){
                competitor.info();
            }
        }
    }
}
