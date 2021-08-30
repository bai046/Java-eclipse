package ѧ����Ϣ����ϵͳ;

import data.DataBase;
import pojo.Student;
import tools.Stulint;
import tools.Stulint;
import tools.Tools;
import view.CourseView;
import view.ManagerPersonView;
import view.GradeView;
import view.StudentView;

/**
 * ���ǳ������������
 *�ο���https://blog.csdn.net/m0_46495243/article/details/115277921?utm_source=app
 */
public class Main {

	public static void main(String[] args) {
		//������ʼ��
		Stulint.start();
		boolean system=true;
		while (system) {
			System.out.println("��ӭʹ��ѧ������ϵͳ");
			System.out.println("-------------------------------------");
			System.out.println("��ѡ���¼���û������ͣ�");
			System.out.println("0������Ա��1��ѧ����2���˳�");
			int userType = Tools.getInteger(Tools.scanner.next(), 1);
			if (userType == 1) {
				System.out.println("��ӭͬѧʹ�ñ�ϵͳ");
				System.out.println("-------------------------------------");
				if (StudentView.login()) {
					boolean flag = true;
					while (flag) {
						System.out.println("��ѡ����Ĳ�����");
						System.out.println("-------------------------------------");
						System.out.println("1:�鿴�Լ�����Ϣ");
						System.out.println("2:�鿴�Լ��ĳɼ�");
						System.out.println("4:�޸��Լ�������");
						System.out.println("3:�˳���¼");
						int type = Tools.getInteger(Tools.scanner.next(), 0);
						
						switch (type) {
						case 1:
							System.out.println(DataBase.getRequest().get("login"));
							break;
						case 2:
							GradeView.find(((Student) DataBase.getRequest().get("login")).getUsername());
							break;
						case 3:
							flag = false;
							break;
						case 4:
							StudentView.updatePwd();
							break;

						default:
							break;
						}
						

					}
				} else {
					System.out.println("�û���¼ʧ��");
					System.out.println("-------------------------------------");

				}
			} else if(userType==0){
				System.out.println("��ӭ����Աʹ�ñ�ϵͳ");
				System.out.println("-------------------------------------");
				if (ManagerPersonView.login()) {
					boolean flag = true;
					while (flag) {
						System.out.println("��ѡ����Ĳ�����");
						System.out.println("-------------------------------------");
						System.out.println("2:�鿴�����û�����Ϣ");
						System.out.println("3:�鿴�����û��ĳɼ�");
						System.out.println("4:�鿴ָ���û��ĳɼ�");
						System.out.println("5:�鿴ָ���û�����Ϣ");
						System.out.println("6:��ӿγ�");
						System.out.println("7:����û�");
						System.out.println("8:��ӳɼ�");
						System.out.println("9:�޸��û�");
						System.out.println("10:�޸ĳɼ�");
						System.out.println("11:�޸Ŀγ�");
						System.out.println("12:��ʾ�γ�");
						System.out.println("20:ɾ��ѧ��");
						System.out.println("13:�˳���¼");
						System.out.println("**********************");
						System.out.println("1:�鿴���˵���Ϣ");
						System.out.println("14:�޸ı�����Ϣ");
						System.out.println("15:�޸���������Ա��Ϣ(��������ԱȨ��)");
						System.out.println("16:���һ���µĹ���Ա(��������ԱȨ��)");
						System.out.println("17:ɾ��һ������Ա(��������ԱȨ��)");
						System.out.println("18:��ѯ���еĹ���Ա����Ϣ(��������ԱȨ��)");
						System.out.println("19:��ѯָ���Ĺ���Ա����Ϣ(��������ԱȨ��)");
						System.out.println("-------------------------------------");
						int type = Tools.getInteger(Tools.scanner.next(), 0);
						switch (type) {
						case 1:
							System.out.println(DataBase.getRequest().get("login"));
							break;
						case 2:
							StudentView.find();
							break;
						case 3:
							GradeView.findAll();
							break;
						case 4:
							StudentView.find();
							GradeView.find();
							break;
						case 5:
							StudentView.findByUsername();
							break;
						case 6:
							CourseView.add();
							break;
						case 7:
							StudentView.add();
							break;
						case 8:
							StudentView.find();
							CourseView.find();
							GradeView.add();
							break;
						case 9:
							StudentView.find();
							StudentView.update();
							break;
						case 10:
							StudentView.find();
							CourseView.find();
							GradeView.update();
							break;
						case 11:
							CourseView.find();
							CourseView.update();
							break;
						case 12:
							CourseView.find();
							break;
						case 13:
							flag = false;
							break;
						case 14:
							ManagerPersonView.updateMy();
							break;
						case 15:
							ManagerPersonView.find();
							ManagerPersonView.update();
							break;
						case 16:
							ManagerPersonView.add();
							break;
						case 17:
							ManagerPersonView.find();
							ManagerPersonView.del();
							break;
						case 18:
							ManagerPersonView.find();
							break;
						case 19:
							ManagerPersonView.findByUsername();
							break;
						case 20:
							StudentView.find();
							StudentView.del();
							break;

						default:
							break;
						}
					}

				}
			}
			else{
				//��������
				Stulint.stop();
				system=false;
			}
		}
	}

}

