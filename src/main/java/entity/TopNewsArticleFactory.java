package entity;

import data_access.NewsAPITopNewsDataAccessObject;

public class TopNewsArticleFactory extends ArticleFactoryTemplate {
    public TopNewsArticleFactory(String parameter) {
        super.parameter = parameter;
        super.dataAccessObject = new NewsAPITopNewsDataAccessObject();
    }
    @Override
    public void fetchData() {
        super.dataAccessObject.getData(super.parameter);
    }

    @Override
    public void computeData() {
        Integer totalResults = super.responseData.getTotalResults();
        super.computedData.add(totalResults);
    }
}
