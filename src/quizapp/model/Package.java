/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizapp.model;
import Admin.Dashboard.Soal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rama Dev
 */
public class Package {

    private String name;
    private List<Material> materials;
    private List<Soal> quizzes;

    public Package(String name) {
        this.name = name;
        this.materials = new ArrayList<>();
        this.quizzes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addMaterial(Material material) {
        materials.add(material);
    }

    public void addQuiz(Soal quiz) {
        quizzes.add(quiz);
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public List<Soal> getQuizzes() {
        return quizzes;
    }

}
