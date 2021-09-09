/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.inscription.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import py.com.ci.academy.assignment.entities.Assignment;
import py.com.ci.academy.utils.ConnectionManager;

/**
 *
 * @author matias
 */
public class Controller {
    
    public List<Assignment> getAssignmentByIdCourse(int courseId) {
        String sql = "select *\n"
                + "from public.courseassignment ca\n"
                + "join public.\"assignment\" a on a.id_assignment = ca.id_assignment\n"
                + "where ca.id_course = ?";
        List<Assignment> assignmentList = new ArrayList();
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Assignment courseAssignment = new Assignment();
                courseAssignment.setIdAssignment(rs.getInt("id_assignment"));
                courseAssignment.setNameAssignment(rs.getString("name_assignment"));
                assignmentList.add(courseAssignment);
            }
            return assignmentList;
        } catch (Exception e) {
            return assignmentList;
        }
    }
    
}
