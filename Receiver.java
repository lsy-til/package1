package class_08_aic;
import java.util.*;

public class Receiver {
    private List<Student> students;
    private IRW rw;
    private List<Command> commands;

    public Receiver(IRW reader, List<Student> students) {
        this.commands = new ArrayList<Command>();
        commands.add(Show.getInstance());
        commands.add(Delete.getInstance());
        commands.add(Add.getInstance());
        commands.add(Update.getInstance());
        this.rw = reader;
        this.students = students;
    }
    
    public int getOperation() {
        rw.writeln("��ϵͳ��ǰ��" + students.size() + "����¼��");
		rw.writeln("ϵͳ�������¹��ܣ�");
		for (int i = 0; i < commands.size(); i++) {
		    rw.writeln(commands.get(i).toString());
		}
        rw.write("��ѡ������Ҫ�����Ĺ���(0��ʾ�˳�ϵͳ)��");
        return rw.readInt();
    }
    
    public void run(int operation) {
        switch (operation) {
            case Show.num:
                rw.writeln("------��ʾ----------");
                rw.write(Show.getInstance().run(buildPara(students)));
                rw.writeln("----------������ʾ-------");
                break;
            case 2:
            	rw.writeln("----------ɾ��------------");
            	int itemId = getItemId();
            	while(itemId != 0){
            		rw.writeln(Delete.getInstance().run(buildParaForDelete(itemId, students)));
	            	itemId = getItemId();
            	}
            	rw.writeln("-------�˳�ɾ��--------");
            	break;
            case Add.num:
            	rw.writeln("----------����------------");
            	int isContinue = 0;
        		do{
        			rw.write(Add.getInstance().run(buildParaForAdd()));
            		rw.write("�Ƿ������0��ʾ�˳�,1��ʾ��������");
            		isContinue = rw.readInt();	
        		}while(isContinue != 0);
            	rw.writeln("-------�˳�����--------");
            	break;
            case Update.num:
    			rw.writeln("------------����---------");
    			rw.write(show());
    			rw.write("��ѡ����Ҫ���µ���Ŀ��ţ�0��ʾ�˳�����");
    			int itemUpdate = rw.readInt();
    			while(itemUpdate != 0){
    				if(itemUpdate >= 1 && itemUpdate <= students.size()){
    					rw.writeln("========�޸���Ŀ"+itemUpdate+"=======");
    					String name = students.get(itemUpdate-1).getName();
    					String id = students.get(itemUpdate-1).getStudentId();
    					rw.writeln("��ѡ��������"+itemUpdate+","+name+"\t"+id+"?");
    					rw.write("��������ϣ���޸ģ�1��������2��ѧ�ţ�0���˳�����");
    					int detailId = rw.readInt();
    					while(detailId != 0){
    						switch(detailId){
    						case 1:
    							rw.write("��������������");
    							name = rw.readString();
    					
    							break;
    						case 2:
    							rw.write("��������ѧ�ţ�");
    							id = rw.readString();
    							break;
    						default:
    							rw.writeln("��������");
    							break;
    						}

    						rw.writeln("��ѡ��������"+itemUpdate+","+name+"\t"+id+"?");
    						rw.write("��������ϣ���޸ģ�1��������2��ѧ�ţ�0���˳�����");
    						detailId = rw.readInt();	
    					}
    					rw.writeln("�˳��޸ġ�");
    					
    					rw.writeln("�Ƿ�"+students.get(itemUpdate-1)+"�޸�Ϊ"+name+"\t"+id+"?");
    					rw.writeln("1:��");
    					rw.writeln("0:��");
    					rw.write("����������ѡ��");
    					int isUpdate = rw.readInt();
    					while(isUpdate != 1&&isUpdate !=0){
    						rw.writeln("��������");

    						rw.writeln("�Ƿ�"+students.get(itemUpdate-1)+"�޸�Ϊ"+name+"\t"+id+"?");
    						rw.writeln("1:��");
    						rw.writeln("0:��");
    						rw.write("����������ѡ��");
    						isUpdate = rw.readInt();
    					}
    					if(isUpdate == 1){
    						students.get(itemUpdate-1).setName(name);
    						students.get(itemUpdate-1).setId(id);
    						rw.writeln("�޸����");
    						
    					}else{
    						rw.writeln("ȡ���޸�");
    					}
    					rw.writeln("===�˳�"+itemUpdate+"�޸�==");
    				}else{
    					rw.writeln("����������");
    				}
    				
    				rw.write(show());
    				rw.write("��ѡ����Ҫ���µ���Ŀ��ţ�0��ʾ�˳�����");
    				itemUpdate = rw.readInt();
    			}
    			rw.writeln("------------���½���---------");
            	break;
            default:
                rw.writeln("��������Ч���֣�0-1����");
        }
    }

	protected ParaForAdd buildParaForAdd() {
		rw.write("������������");
		String name = rw.readString();
		rw.write("������ѧ�ţ�");
		String studentId = rw.readString();
		rw.writeln("�Ƿ�����ѧ����"+name+"\t"+studentId+"?");
		rw.writeln("1:��");
		rw.writeln("0:��");
		int isAdd = rw.readInt();                	
		ParaForAdd para = new ParaForAdd(students,name, studentId, isAdd);
		return para;
	}

	protected ParaForDelete buildParaForDelete(int itemId, List<Student> students) {
		int isOk = 0;
		if(itemId >=1 && itemId <= students.size()){
			isOk = isOk(itemId);
			while(isOk != 1 && isOk != 0 ){
				rw.writeln("�������ѡ����ڡ�");
				isOk = isOk(itemId);
			}
		}
		return new ParaForDelete(students, itemId, isOk);
	}

	private ParaForCommand buildPara(List<Student> students2) {
		return new ParaForCommand(students);
	}

	protected int isOk(int itemId) {
		rw.writeln("�����Ƿ���Ҫɾ�����Ϊ"+itemId+","+students.get(itemId-1));
		rw.writeln("1:��");
		rw.writeln("0:��");
		rw.write("��������ѡ��");
		int isOk = rw.readInt();
		return isOk;
	}

	protected int getItemId() {
		rw.write(show());
		rw.write("��ѡ����Ҫɾ������ţ�0���˳�ɾ������");
		int itemId = rw.readInt();
		return itemId;
	}
    
    public String show(){//TODO �ع�
        StringBuffer res = new StringBuffer();
        res.append("���\t����\tѧ��" + "\r\n");
        for (int i = 0; i < students.size(); i++) {
            res.append(i + 1 + "\t" + students.get(i).toString() + "\r\n");
        }
        return res.toString();
    }
    
    
}


