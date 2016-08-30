% 大学数学实验2 p.302,306,312-313 实验12 实例1,例1 血压与年龄
% 大学数学实验  p.289,293,299-301 实验12 实例1,例1 血压与年龄

clear

[A,B] = xlsread('dxsxsy2.xls', '13_1');
%A1=textread('JZ301.txt');
dlmwrite('test1.dat',A,'\t')
dlmwrite('test2.dat',A)
csvwrite('test3.dat',A)
Atext=textread('test1.dat');
Adlm=dlmread('test2.dat');
Acsv=csvread('test3.dat');
%xlswrite('test4.xls', A, '12_01') 	%6.5版本下不可用
%xlswrite('test4.xls', A, '12_01BF') 	%6.5版本下不可用

y = A(:, 2); 	%第2列数据是血压y
x = A(:, 3); 	%第3列数据是年龄x
plot(x,y,'*'), grid
%set(gcf,'color','n')	% 'n'无颜色，'k'黑色，'w'白色，gca :中间
pause

X = [ones(30,1), x];
[b, bint, r, rint, stat ] = regress(y, X) ;
b, bint, stat, s_2 = r'*r/(30-2)	
rcoplot(r, rint), pause
%rcoplotw(r, rint)	%  《rcoplotw》——王振羽重设了线条色与底色

X1 = X; X1(2,:)=[];  % 剔除第2点
y1 = y; y1(2)=[];
[b1, bint1, r1, rint1, stat1 ] = regress(y1, X1) ;
b1, bint1, stat1, s1_2 = r1'*r1/(29-2)
rcoplot(r1, rint1)
%rcoplotw(r1, rint1)	
