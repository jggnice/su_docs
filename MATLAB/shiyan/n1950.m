n=1950;
while(((normcdf(n,2000,50)-normcdf(0,2000,50))/(1-(normcdf(n,2000,50))))<2*n/(15000-n))
    n=n+1;
end