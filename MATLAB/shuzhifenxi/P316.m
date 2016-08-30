h = 0.1;
x = 0:h:0.5;
y = x;
%%%%%%%%% 改进的欧拉公式 %%%%%%%%%%%
for ii = 1:5
   tep = [x(ii) y(ii)];
   ytep = y(ii) + h*fun316(tep);
   tep = [x(ii + 1) ytep];
  ytep2 = y(ii) + h*fun316(tep);
  y(ii + 1) = (ytep+ytep2)/2;
end
plot(x,y,'b');
hold on
%%%%%%%%%%  梯形方法   %%%%%%%%%%%%%
for ii = 1:5
   tep1 = [x(ii) y(ii)];
    y(ii + 1) = y(ii) + h*fun316(tep);    
  for jj = 1: 100
      tep2 = [x(ii + 1) y(ii + 1)];
      y(ii + 1) = y(ii) + h/2*(fun316(tep1) + fun316(tep2));
  end
end
plot(x,y,'r');
%%%%%%%%%%  精确求解   %%%%%%%%%%%%%
x1 = 0:0.01:0.5;
y1 = -exp(-x1)+x1.*x1-x1+1;
plot(x1,y1,'g');
hold off
