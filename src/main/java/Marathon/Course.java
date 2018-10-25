package Marathon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Course {
    private String name;
    private Barrier[] barriers;

    public void doIt(Team team){
        System.out.println("Команда \"" + team.getName() + "\" начала свое выступление на полосе препятствий \"" + name + "\"");
        for (Competitor c : team.getParticipants()) {
            for (Barrier b : this.barriers) {
                b.doIt(c);
                if (!c.isOnDistance()) {
                    break;
                }
            }
        }
    }
}
