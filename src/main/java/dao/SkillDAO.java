package dao;

import model.Entity;
import model.Skill;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillDAO extends EntityDAO{
    Skill skill;

    @Override
    public void create(Entity entity) throws SQLException {
        skill = (Skill) entity;
        String sql = "INSERT INTO `my_schema`.`skills` VALUES ('" + skill.getId() + "', '"
                + skill.getName() + "', '" + skill.getDeveloper_id() + "')";

        statement.execute(sql);
        System.out.println("Skill " + skill.getName() + " added to database.");
    }

    @Override
    public void read() throws SQLException {
        String sql;
        sql = "SELECT * FROM `my_schema`.`skills`";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
        System.out.println("\nSkills:");
        while (resultSet.next()) {
            skill = new Skill(resultSet.getInt("skill_id"), resultSet.getString("skillname"),
                    resultSet.getInt("dev_id"));

            System.out.println("\n================\n");
            System.out.println("id: " + skill.getId());
            System.out.println("Name: " + skill.getName());
            System.out.println("Developer id=" + skill.getDeveloper_id());
        }
        resultSet.close();
    }

    @Override
    public void update(Entity entity) throws SQLException {
        skill = (Skill) entity;
        String sql = "UPDATE `my_schema`.`skills` SET `name`='" + skill.getName() +
                ", `dev_id`=`" + skill.getDeveloper_id() +
                " WHERE `dev_id`='" + skill.getId() + "'";

        statement.execute(sql);
        System.out.println("Skill " + skill.getName() + " has been updated");
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM `my_schema`.`skills` WHERE `skill_id`='" + id + "';";

        statement.execute(sql);
        System.out.println("Skill with id=" + id + " has been deleted.");
    }

}
