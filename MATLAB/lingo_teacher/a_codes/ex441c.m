% ��ѧ��ѧʵ��2  p.68-69,76-80  ��1   ���ϼ�˽
% ��ѧ��ѧʵ��   p.68,69,75-79  ��1   ���ϼ�˽ 
% �ں���ĳ����˽ͧ�ϵ��״﷢���������� c ���ﴦ��һ��
% ��˽�������ٶ� a ������������ʻ����˽ͧ�����������
% �� b ( > a ) ǰ�����ء�������״���и���ʱ, �ɱ��ּ�˽
% ͧ���ٶȷ���ʼ��ָ����˽��
ts = 0:0.1:1.6;		% �յ���̽������Ϊ0.5�������������0.05
%  ts = 0:0.1:1;   ts = 0:0.1:1.2;  ts = 0:0.1:1.4; ts = 0:0.1:8;  ts = 0:0.1:2;    
x0 = [0 0];			% ����x, y �ĳ�ֵ
a = 35;  b = 40;  c = 15;	% 
opt=odeset('RelTol',1e-6, 'AbsTol',1e-9);	%����ode45�����о���
[t, x] = ode45(@ex441jisi, ts, x0, opt, a,b,c);	%ʹ��opt���õľ��ȵ���ode45����
x1=0*t+c; y1=a*t; 		% x1 ,y1����˽����������
%output t,x(t),y(t)
[t,x,y1]			% ��� t,x(t),y(t),y1(t)
figure(1)
plot(t,x,'LineWidth',2),grid,	% p.77ͼ44(a):x(t),y(t)��ͼ��
text(t(10),x(10,1),'x(t)','FontSize',16),
text(t(10),x(10,2),'y(t)','FontSize',16)
hold on,plot(t,y1,':k','LineWidth',1.5);	% �ӻ���˽����y1(t)
text(t(10),y1(10),'����y(t)'),hold off
%draw y(x): the position of catch js
figure(2)
p1 = get(1,'position');	% ��õ�1��ͼ�ε�λ��
set(2,'position',p1+[200 -50 0 0]); % ���2��ͼ�ε�λ��
plot(x1,y1,'.',x(:,1),x(:,2),'ro'),	% p.77ͼ4.4(b):y1(x1), y(x)��ͼ��, ��˽ͧץ����˽��
grid,
xlabel('x','FontSize',16),
ylabel('y','FontSize',16)
