% ��ѧ��ѧʵ��2  p.50  (����)
% 3.2.4  �����ֲ�ֵ��������g(x)=1/(1+x^2),����[-5,5], n=10�ȷ�
clf,shg,      % CLF Clear current figure
n = 11;  m = 21;
x = -5:10/(m-1):5;                % ������ֵ��x,���0.1
y = 1./(1+x.^2);plot(x,y),pause   % ���� g(x),���ڱȽ�

x0 = -5:10/(n-1):5;
y0 = 1./(1+x0.^2);       % �����ڵ� (x0,y0)	
y1 = ex324lagr(x0,y0,x);hold on,plot(x,y1,'r'),pause   % �����������ղ�ֵ
y2 = interp1(x0,y0,x);hold on,plot(x,y2,'b'),pause     % ����ֶ����Բ�ֵ
y3 = interp1(x0,y0,x,'spline');hold on,plot(x,y3,'k*') % ��������������ֵ


% s='      x         y        y1         y2        y3'
% [x(11:21)' y(11:21)' y1(11:21)' y2(11:21)' y3(11:21)']
