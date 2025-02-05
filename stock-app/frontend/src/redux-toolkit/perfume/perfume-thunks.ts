import { createAsyncThunk } from "@reduxjs/toolkit";

import RequestService from "../../utils/request-service";
import {PERFUMES, PERFUMES_GRAPHQL_PERFUME, REVIEW} from "../../constants/urlConstants";
import { getProductByQuery } from "../../utils/graphql-query/perfume-query";
import { FullProductResponse, ReviewResponse } from "../../types/types";

export const fetchProduct = createAsyncThunk<Partial<FullProductResponse>, string, { rejectValue: string }>(
    "perfume/fetchProduct",
    async (perfumeId, thunkApi) => {
        try {
            const response = await RequestService.get(`${PERFUMES}/${perfumeId}`);
            return response.data;
        } catch (error) {
            return thunkApi.rejectWithValue(error.response.data);
        }
    }
);

export const fetchReviewsByProductId = createAsyncThunk<Array<ReviewResponse>, string>(
    "perfume/fetchReviewsByProductId",
    async (perfumeId) => {
        const response = await RequestService.get(`${REVIEW}/${perfumeId}`);
        return response.data;
    }
);

// GraphQL thunks
export const fetchProductByQuery = createAsyncThunk<Partial<FullProductResponse>, string, { rejectValue: string }>(
    "perfume/fetchProductByQuery",
    async (perfumeId, thunkApi) => {
        try {
            const response = await RequestService.post(PERFUMES_GRAPHQL_PERFUME, {
                query: getProductByQuery(perfumeId)
            });
            return response.data.data.perfume;
        } catch (error) {
            return thunkApi.rejectWithValue(error.response.data);
        }
    }
);
