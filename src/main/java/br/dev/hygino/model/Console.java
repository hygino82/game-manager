package br.dev.hygino.model;

import java.time.LocalDate;

public class Console {
    
    private int id;
    private String name;
    private String company;
    private LocalDate releaseDate;

    public Console() {
    }

    public Console(String name, String company, LocalDate releaseDate) {
        this.name = name;
        this.company = company;
        this.releaseDate = releaseDate;
    }

    public Console(int id, String name, String company, LocalDate releaseDate) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Console{" + "id=" + id + ", name=" + name + ", company=" + company + ", releaseDate=" + releaseDate + '}';
    }
}
