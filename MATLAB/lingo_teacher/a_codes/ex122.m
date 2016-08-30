% p.9-10 例1.2.2的图形--蛛网  255 243 214
x0 = 100; y0 = 10;	% 100单位，10元/单位
x1 = 110; n=1:10;
x = [x1]; y = []; alpha = 0.1; beta = 5;
for k=n
    y(k) = y0 - alpha*(x(k)-x0);
    x(k+1) = x0 + beta*(y(k)-y0);
end
plot(n, x(n),'linewidth',1.5),grid on,  	%图1.5(a) 
text(3.2,102.5,'\fontsize{14}\itx_{k}'), text(9.6,95.5,'\fontsize{14}\itk'), 
text(7.2,109,'\fontsize{16}\bf\it\alpha\rm\bf = 0.1, \bf\it\beta\rm\bf = 5'),
set(gcf,'color',[1 .953 .839])       %2008a版本中图片不复制底色，此句没有用处
pause

plot(n, y(n),'linewidth',1.5),grid on, 		 %图1.5(b)
text(2.4,10.3,'\fontsize{14}\ity_{k}'), text(9.6,9.1,'\fontsize{14}\itk'), 
text(7.2,10.4,'\fontsize{16}\bf\it\alpha\rm\bf = 0.1, \bf\it\beta\rm\bf = 5'),
set(gcf,'color',[1 .953 .839])
pause

x = [x1]; y = []; alpha = 0.24; beta = 5;
for k=n
    y(k) = y0 - alpha*(x(k)-x0);
    x(k+1) = x0 + beta*(y(k)-y0);
end
plot(n, x(n),'linewidth',1.5),grid on, 		 %图1.6(a)
text(3.4,105,'\fontsize{14}\itx_{k}'), text(9.6,45,'\fontsize{14}\itk'),
text(1.2,150,'\fontsize{16}\bf\it\alpha\rm\bf = 0.24, \bf\it\beta\rm\bf = 5'),
set(gcf,'color',[1 .953 .839])
pause

plot(n, y(n),'linewidth',1.5),grid on, 		 %图1.6(b)
axis([1 10 0 25])
text(4.3,13,'\fontsize{14}\ity_{k}'), text(9.6,1,'\fontsize{14}\itk'), 
text(1.2,23,'\fontsize{16}\bf\it\alpha\rm\bf = 0.24, \bf\it\beta\rm\bf = 5'),
set(gcf,'color',[1 .953 .839])

