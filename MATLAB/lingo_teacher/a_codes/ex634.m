% ��ѧ��ѧʵ��  p.114-115,125-127  ��1  ·������ 
clear
P1 = 2; P2 = 3; s = 20;
% ����C(x)��C'(x)��ͼ��
x = (0:0.1:20)';
C  = ex634f1(x,5,6);		%h1,h2,P1,P2,s,����h1=5,h2=6ʱ��C����
dC = ex634f2(x);		%h1,h2,P1,P2,s
figure(1)
plot(x, C),grid,
set(gcf,'color',[1 .953 .839])	
text(x(80), C(80),'C(x)','fontsize',14)
figure(2)
plot(x, dC),grid,
set(gcf,'color',[1 .953 .839])	
text(x(80), dC(80),'C��(x)','fontsize',14)

% h1 = 5, h2 = 6ʱ�� 0, 10, 20 ������ C'(x) = 0 �ĸ������Ƚ�פ�㼰0,20���ĺ���ֵ
x0 = [ 0, 10, 20];x1=[];
for k = 1:3
    x1(k) = fzero(@ex634f2, x0(k));
end
x1 = [0, x1, 20];
c1 = ex634f1(x1,5,6);
format long
x1_c1 = [x1;c1]
%
%x:       0                                  0.02848997037927   9.33829913634669   19.97669580711598  20
%C(x)   0.08197716435023   0.08198104004444   0.01824392571618   0.08447655492158   0.08447467745115

%===================��2�ʣ�h2�ɱ�ʱ==========================
% ����p.126(38)ʽͼ��
x = (0:0.1:18)';	% x > 18ʱ |C3|�ܴ�
C2 =  ex634f3(x);		%h1,h2,P1,P2,s
figure(3)
plot(x, C2),grid,		%��0,10�����и�

% h1 = 5, h2 = 6ʱ�� 0, 10 ������ C'(x) = 0 �ĸ������Ƚ�פ�㼰0,20���ĺ���ֵ
x2 = 0;			% ��x = 20��C3������
x2(2) = fzero(@ex634f3, 0);
x2(3) = fzero(@ex634f3, 10);
h2b = (20 - x2) / sqrt(2);  
c2 = ex634f1(x2, 5, h2b);

x2_h2_c2 = [x2;h2b;c2]
%
%x                 0                                  0.03020975865663    9.50315131015735
%h2           14.14213562373095  14.12077409852683    7.42239288967686   %h2 = 14������Ҫ��
% C(x,h2)  0.08288675134595      0.08289111152917    0.01855583599319

%===================��3�ʣ�h1, h2���ɱ�==========================
h1 = 5; h2 = 6;  P1 = 2; P2 = 3; s = 20;
x3 = s*P1^(1/3)/(P1^(1/3) + P2^(1/3));
h1c = x3 / sqrt(2);
h2c = (20 - x3) / sqrt(2); 
c3 = ex634f1(x3, h1c, h2c);

x3_h1h2_c3 = [x3,h1c,h2c,c3]
% 9.32525163640893     6.59394866837571     7.54818695535525    0.01898569175120

