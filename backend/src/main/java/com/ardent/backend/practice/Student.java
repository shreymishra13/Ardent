package com.ardent.backend.practice;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    private int roll ;



    @Override
    public boolean equals(Object object) {
        Student other = (Student) object;
        return this.roll == other.getRoll();
    }
}
