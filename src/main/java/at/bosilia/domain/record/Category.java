package at.bosilia.domain.record;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Category {

    @Id @Size(min = 1, max = 20)
    private String name;
    @Max(value = 50)
    private String description;
    @OneToMany(mappedBy = "category")
    private final List<Record> records = new ArrayList<>();

    public void addRecords(Record record){
        this.records.add(record);
    }
}
