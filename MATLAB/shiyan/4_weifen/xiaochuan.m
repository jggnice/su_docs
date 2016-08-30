function dy=xiaochuan(t,y)
v1=1.5;v2=2;s=sqrt(y(1)^2+y(2)^2);
dy=[v1-v2*y(1)/s;-v2*y(2)/s];