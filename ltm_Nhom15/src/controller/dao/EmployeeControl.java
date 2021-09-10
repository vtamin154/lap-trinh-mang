package controller.dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import view.EmployeeView;

public class EmployeeControl {
	EmployeeView view;
	DAOEmployee dao;
	Employee[] emlopyees;
	public EmployeeControl(EmployeeView view) {
		try {
			dao = new DAOEmployee(new Cn().getConnection());
			this.view = view;
//                        view.HienThi(this.displayAll());
                        view.HienThi(new HienThiListioner());
                        view.Them(new CreateListioner());
                        view.CapNhat(new UpdateListioner());
                        view.Xoa(new deleteListioner());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.dao.closeConnection();
			System.exit(0);
		}
	}

	
	private Employee[] displayAll(){
		return this.dao.selectAll();
	}
	private Employee[] displayByName(String name){
		return this.dao.selectByName(name);
	}
        private int createEmployee(Employee e){
		return this.dao.insert(e);
	}
	public void exit(){
		this.dao.closeConnection();
		this.view.exit();
	}
        
        public class HienThiListioner implements ActionListener {
            public void actionPerformed(ActionEvent event){
                view.HT(displayAll());
            }
        }
        
        public class UpdateListioner implements ActionListener {
            public void actionPerformed(ActionEvent event){
                try {
                    dao.update(view.getEmp());
                } catch (ParseException ex) {
                    Logger.getLogger(EmployeeControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        public class deleteListioner implements ActionListener {
            public void actionPerformed(ActionEvent event){
                dao.delete(view.getXoa());
            }
        }
        
        public class CreateListioner implements ActionListener{
            public void actionPerformed(ActionEvent event){
                try {
                    createEmployee(view.getEmp());
                } catch (ParseException ex) {
                    Logger.getLogger(EmployeeControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
}

