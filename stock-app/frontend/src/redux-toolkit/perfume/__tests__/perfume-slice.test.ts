import MockAdapter from "axios-mock-adapter";
import axios from "axios";

import { LoadingStatus } from "../../../types/types";
import { API_BASE_URL, PERFUMES, PERFUMES_GRAPHQL_PERFUME, REVIEW } from "../../../constants/urlConstants";
import { store } from "../../../store";
import { initialState } from "../perfume-slice";
import { mockFullProductResponse, mockReviews } from "../../../utils/test/__mocks__/perfumes-mock";
import { fetchProduct, fetchProductByQuery, fetchReviewsByProductId } from "../perfume-thunks";

describe("perfume slice tests", () => {
    const mock = new MockAdapter(axios);
    let state = store.getState().perfume;

    beforeEach(() => {
        state = initialState;
    });

    it("should fetchProduct dispatches fulfilled on success", async () => {
        expect(state.perfume).toEqual({});
        expect(state.loadingState).toEqual(LoadingStatus.LOADING);

        mock.onGet(API_BASE_URL + `${PERFUMES}/34`).reply(200, mockFullProductResponse);
        const result = await store.dispatch(fetchProduct("34"));

        state = store.getState().perfume;
        expect(result.type).toBe("perfume/fetchProduct/fulfilled");
        expect(state.perfume).toEqual(mockFullProductResponse);
        expect(state.loadingState).toEqual(LoadingStatus.LOADED);
    });

    it("should fetchProduct dispatches rejected on failure", async () => {
        expect(state.errorMessage).toEqual("");
        expect(state.loadingState).toEqual(LoadingStatus.LOADING);

        mock.onGet(API_BASE_URL + `${PERFUMES}/34`).reply(400, "ERROR");
        const result = await store.dispatch(fetchProduct("34"));

        state = store.getState().perfume;
        expect(result.type).toBe("perfume/fetchProduct/rejected");
        expect(state.errorMessage).toEqual("ERROR");
        expect(state.loadingState).toEqual(LoadingStatus.ERROR);
    });

    it("should fetchReviewsByProductId dispatches fulfilled on success", async () => {
        expect(state.reviews).toEqual([]);
        expect(state.loadingState).toEqual(LoadingStatus.LOADING);

        mock.onGet(API_BASE_URL + `${REVIEW}/34`).reply(200, mockReviews);
        const result = await store.dispatch(fetchReviewsByProductId("34"));

        state = store.getState().perfume;
        expect(result.type).toBe("perfume/fetchReviewsByProductId/fulfilled");
        expect(state.reviews).toEqual(mockReviews);
        expect(state.loadingState).toEqual(LoadingStatus.LOADED);
    });

    it("should fetchProductByQuery dispatches fulfilled on success", async () => {
        expect(state.perfume).toEqual({});
        expect(state.loadingState).toEqual(LoadingStatus.LOADING);

        mock.onPost(API_BASE_URL + PERFUMES_GRAPHQL_PERFUME).reply(200, { data: { perfume: mockFullProductResponse } });
        const result = await store.dispatch(fetchProductByQuery("1"));

        state = store.getState().perfume;
        expect(result.type).toBe("perfume/fetchProductByQuery/fulfilled");
        expect(state.perfume).toEqual(mockFullProductResponse);
        expect(state.loadingState).toEqual(LoadingStatus.LOADED);
    });

    it("should fetchProductByQuery dispatches rejected on failure", async () => {
        expect(state.errorMessage).toEqual("");
        expect(state.loadingState).toEqual(LoadingStatus.LOADING);

        mock.onPost(API_BASE_URL + PERFUMES_GRAPHQL_PERFUME).reply(400, "ERROR");
        const result = await store.dispatch(fetchProductByQuery("1"));

        state = store.getState().perfume;
        expect(result.type).toBe("perfume/fetchProductByQuery/rejected");
        expect(state.errorMessage).toEqual("ERROR");
        expect(state.loadingState).toEqual(LoadingStatus.ERROR);
    });
});
