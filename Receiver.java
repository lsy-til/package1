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
        rw.writeln("本系统当前有" + students.size() + "条记录。");
		rw.writeln("系统具有以下功能：");
		for (int i = 0; i < commands.size(); i++) {
		    rw.writeln(commands.get(i).toString());
		}
        rw.write("请选择您需要操作的功能(0表示退出系统)：");
        return rw.readInt();
    }
    
    public void run(int operation) {
        switch (operation) {
            case Show.num:
                rw.writeln("------显示----------");
                rw.write(Show.getInstance().run(buildPara(students)));
                rw.writeln("----------结束显示-------");
                break;
            case 2:
            	rw.writeln("----------删除------------");
            	int itemId = getItemId();
            	while(itemId != 0){
            		rw.writeln(Delete.getInstance().run(buildParaForDelete(itemId, students)));
	            	itemId = getItemId();
            	}
            	rw.writeln("-------退出删除--------");
            	break;
            case Add.num:
            	rw.writeln("----------新增------------");
            	int isContinue = 0;
        		do{
        			rw.write(Add.getInstance().run(buildParaForAdd()));
            		rw.write("是否继续（0表示退出,1表示继续）：");
            		isContinue = rw.readInt();	
        		}while(isContinue != 0);
            	rw.writeln("-------退出新增--------");
            	break;
            case Update.num:
    			rw.writeln("------------更新---------");
    			rw.write(show());
    			rw.write("请选择需要更新的条目序号（0表示退出）：");
    			int itemUpdate = rw.readInt();
    			while(itemUpdate != 0){
    				if(itemUpdate >= 1 && itemUpdate <= students.size()){
    					rw.writeln("========修改条目"+itemUpdate+"=======");
    					String name = students.get(itemUpdate-1).getName();
    					String id = students.get(itemUpdate-1).getStudentId();
    					rw.writeln("您选择的序号是"+itemUpdate+","+name+"\t"+id+"?");
    					rw.write("请问您是希望修改（1：姓名，2：学号，0：退出）：");
    					int detailId = rw.readInt();
    					while(detailId != 0){
    						switch(detailId){
    						case 1:
    							rw.write("请输入新姓名：");
    							name = rw.readString();
    					
    							break;
    						case 2:
    							rw.write("请输入新学号：");
    							id = rw.readString();
    							break;
    						default:
    							rw.writeln("输入有误。");
    							break;
    						}

    						rw.writeln("您选择的序号是"+itemUpdate+","+name+"\t"+id+"?");
    						rw.write("请问您是希望修改（1：姓名，2：学号，0：退出）：");
    						detailId = rw.readInt();	
    					}
    					rw.writeln("退出修改。");
    					
    					rw.writeln("是否将"+students.get(itemUpdate-1)+"修改为"+name+"\t"+id+"?");
    					rw.writeln("1:是");
    					rw.writeln("0:否");
    					rw.write("请输入您的选择：");
    					int isUpdate = rw.readInt();
    					while(isUpdate != 1&&isUpdate !=0){
    						rw.writeln("输入有误。");

    						rw.writeln("是否将"+students.get(itemUpdate-1)+"修改为"+name+"\t"+id+"?");
    						rw.writeln("1:是");
    						rw.writeln("0:否");
    						rw.write("请输入您的选择：");
    						isUpdate = rw.readInt();
    					}
    					if(isUpdate == 1){
    						students.get(itemUpdate-1).setName(name);
    						students.get(itemUpdate-1).setId(id);
    						rw.writeln("修改完成");
    						
    					}else{
    						rw.writeln("取消修改");
    					}
    					rw.writeln("===退出"+itemUpdate+"修改==");
    				}else{
    					rw.writeln("序号输入错误。");
    				}
    				
    				rw.write(show());
    				rw.write("请选择需要更新的条目序号（0表示退出）：");
    				itemUpdate = rw.readInt();
    			}
    			rw.writeln("------------更新结束---------");
            	break;
            default:
                rw.writeln("请输入有效数字（0-1）。");
        }
    }

	protected ParaForAdd buildParaForAdd() {
		rw.write("请输入姓名：");
		String name = rw.readString();
		rw.write("请输入学号：");
		String studentId = rw.readString();
		rw.writeln("是否增加学生："+name+"\t"+studentId+"?");
		rw.writeln("1:是");
		rw.writeln("0:否");
		int isAdd = rw.readInt();                	
		ParaForAdd para = new ParaForAdd(students,name, studentId, isAdd);
		return para;
	}

	protected ParaForDelete buildParaForDelete(int itemId, List<Student> students) {
		int isOk = 0;
		if(itemId >=1 && itemId <= students.size()){
			isOk = isOk(itemId);
			while(isOk != 1 && isOk != 0 ){
				rw.writeln("您输入的选项不存在。");
				isOk = isOk(itemId);
			}
		}
		return new ParaForDelete(students, itemId, isOk);
	}

	private ParaForCommand buildPara(List<Student> students2) {
		return new ParaForCommand(students);
	}

	protected int isOk(int itemId) {
		rw.writeln("请问是否需要删除序号为"+itemId+","+students.get(itemId-1));
		rw.writeln("1:是");
		rw.writeln("0:否");
		rw.write("请问您的选择：");
		int isOk = rw.readInt();
		return isOk;
	}

	protected int getItemId() {
		rw.write(show());
		rw.write("请选择您要删除的序号（0：退出删除）：");
		int itemId = rw.readInt();
		return itemId;
	}
    
    public String show(){//TODO 重构
        StringBuffer res = new StringBuffer();
        res.append("序号\t姓名\t学号" + "\r\n");
        for (int i = 0; i < students.size(); i++) {
            res.append(i + 1 + "\t" + students.get(i).toString() + "\r\n");
        }
        return res.toString();
    }
    
    
}


