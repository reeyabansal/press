package entity;

import data_access.NewsAPIKeywordDataAccessObject;

public class KeywordArticleFactory extends ArticleFactoryTemplate {
    public KeywordArticleFactory(String parameter) {
        super.parameter = parameter;
        super.dataAccessObject = new NewsAPIKeywordDataAccessObject();
    }
    @Override
    public void fetchData() {
        super.dataAccessObject.getData(this.parameter);
    }

    @Override
    // no extra data to compute
    public void computeData() {
        return;
    }
}
