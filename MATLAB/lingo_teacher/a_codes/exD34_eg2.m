% 大学数学实验|2 p.290|302,305-306|317-318 
% 实验12|13 实例2, 血压与年龄、体重指数、吸烟习惯 

clear

[A,B] = xlsread('dxsxsy2.xls', '13_2');

y = A(:, 2); 	%第2列数据是血压y
x1 = A(:, 3); 	%第3列数据是年龄x1
x2 = A(:, 4); 	%第4列数据是体重指数x2
x3 = A(:, 5); 	%第5列数据是吸烟习惯x3
plot(x2,y,'*'), grid
set(gcf,'color','n')	% 'n'无颜色，'k'黑色，'w'白色，gca :中间
%set(gcf,'color',[1 .953 .839])	

X = [ones(30,1), x1,x2,x3];
[b, bint, r, rint, stat ] = regress(y, X) ;
b, bint, stat, s_2 = r'*r/(30-3-1)
rcoplotw(r, rint)	%  《rcoplotw》——王振羽重设了线条色与底色

X1 = X; X1([2,10],:)=[];    % 剔除第2,10点
y1 = y; y1([2 10])=[];
%X1 = X([1,3:9,11:30],:);	%剔除第2、10点
%y1 = y([1,3:9,11:30]);
[b1, bint1, r1, rint1, stat1 ] = regress(y1, X1) ;
b1, bint1, stat1, s1_2 = r1'*r1/(28-3-1)
figure(2)
rcoplotw(r1, rint1)	