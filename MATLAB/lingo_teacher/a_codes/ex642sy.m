% ��ѧ��ѧʵ��  p.35-38      2.4.1 ��6  ��ɢ��ʽ����������ģ��(Logisticģ��)  
% ��ѧ��ѧʵ��  p.129-131  6.4           �ֲ����������  
% x.k ~ ĳ��Ⱥ�� k �������� :x.k+1 �C x.k = r ( 1 �C x.k/N ) x.k   
% 
y0 = 0.01;
b = 3.555
y = y0;
for i = 1:999
  y(i+1) =  b*y(i)*(1-y(i));
end
y=y';