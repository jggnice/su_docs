% 大学数学实验2  p.68-69,76-80  例1   海上缉私
% 大学数学实验   p.68,69,75-79  例1   海上缉私 
% 在海防某部缉私艇上的雷达发现正东方向 c 海里处有一艘
% 走私船正以速度 a 向正北方向行驶，缉私艇立即以最大速
% 度 b ( > a ) 前往拦截。如果用雷达进行跟踪时, 可保持缉私
% 艇的速度方向始终指向走私船
if  ~ exist('ts')
   ts = 0:0.025:0.5;		% 终点试探，调整为0.5，输出“步长”0.05, 可在命令行中直接写ts
end			% 可以试 ts = 0:0.05:0.5;  ts = 0:0.05:0.7;  ts = 0:0.1:1.0;  等
x0 = [0 0];			% 输入x, y 的初值
a = 20;  b = 40;  c = 15;	% 
[t, x] = ode45(@ex441jisi, ts, x0, [], a,b,c);	%调用ode45计算，[]表示使用ode45的默认选项
x1=0*t+c; y1=a*t; 		% x1 ,y1是走私船的纵坐标
%output t,x(t),y(t)
[t,x,y1]			% 输出 t,x(t),y(t),y1(t)
figure(1)
plot(t,x,'LineWidth',2),grid,	% p.77图4.3(a):x(t),y(t)的图形
text(t(10),x(10,1),'x(t)','FontSize',16),
text(t(10),x(10,2),'y(t)','FontSize',16)
hold on,plot(t,y1,':k','LineWidth',1.5);	% 加画走私船的y1(t)
text(t(10),y1(10),'船的y(t)'),hold off
%draw y(x): the position of catch js
figure(2)
p1 = get(1,'position');	% 获得第1个图形的位置
set(2,'position',p1+[200 -50 0 0]); % 设第2个图形的位置
plot(x1,y1,'.',x(:,1),x(:,2),'ro'),	% p.77图4.3(b):y1(x1), y(x)的图形, 缉私艇抓捕走私船
grid,
xlabel('x','FontSize',16),
ylabel('y','FontSize',16)


%    [T,Y] = ode45(ODEFUN,TSPAN,Y0,OPTIONS,P1,P2...) passes the additional
%    parameters P1,P2,... to the ODE function as ODEFUN(T,Y,P1,P2...), and to
%    all functions specified in OPTIONS. Use OPTIONS = [] as a place holder if
%    no options are set.   