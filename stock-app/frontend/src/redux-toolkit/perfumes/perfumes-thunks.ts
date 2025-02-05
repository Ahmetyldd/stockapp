import { createAsyncThunk } from "@reduxjs/toolkit";

import RequestService from "../../utils/request-service";
import {
    PERFUMES,
    PERFUMES_GRAPHQL_IDS,
    PERFUMES_GRAPHQL_PERFUMES,
    PERFUMES_IDS,
    PERFUMES_SEARCH,
    PERFUMES_SEARCH_TEXT
} from "../../constants/urlConstants";
import { FilterParamsType, HeaderResponse, ProductResponse, ProductsSearchRequest } from "../../types/types";
import { geProductsByIdsQuery, getAllProductsByQuery } from "../../utils/graphql-query/perfume-query";

export const fetchProducts = createAsyncThunk<HeaderResponse<ProductResponse>, number>(
    "perfumes/fetchProducts",
    async (page) => {
        const response = await RequestService.get(`${PERFUMES}?page=${page}`);
        return {
            items: response.data,
            pagesCount: parseInt(response.headers["page-total-count"]),
            totalElements: parseInt(response.headers["page-total-elements"])
        };
    }
);

export const fetchProductsByIds = createAsyncThunk<Array<ProductResponse>, Array<number>>(
    "perfumes/fetchProductsByIds",
    async (ids) => {
        const response = await RequestService.post(PERFUMES_IDS, ids);
        return response.data;
    }
);

export const fetchProductsByFilterParams = createAsyncThunk<HeaderResponse<ProductResponse>, FilterParamsType>(
    "perfumes/fetchProductsByFilterParams",
    async (filter) => {
        const response = await RequestService.post(`${PERFUMES_SEARCH}?page=${filter.currentPage}`, filter);
        return {
            items: response.data,
            pagesCount: parseInt(response.headers["page-total-count"]),
            totalElements: parseInt(response.headers["page-total-elements"])
        };
    }
);

export const fetchProductsByInputText = createAsyncThunk<HeaderResponse<ProductResponse>, ProductsSearchRequest>(
    "perfumes/fetchProductsByInputText",
    async (data) => {
        const response = await RequestService.post(`${PERFUMES_SEARCH_TEXT}?page=${data.currentPage}`, data);
        return {
            items: response.data,
            pagesCount: parseInt(response.headers["page-total-count"]),
            totalElements: parseInt(response.headers["page-total-elements"])
        };
    }
);

// GraphQL thunks
export const fetchProductsByQuery = createAsyncThunk<Array<ProductResponse>>("perfumes/fetchProductsByQuery", async () => {
    const response = await RequestService.post(PERFUMES_GRAPHQL_PERFUMES, { query: getAllProductsByQuery });
    return response.data.data.perfumes;
});

export const fetchProductsByIdsQuery = createAsyncThunk<Array<ProductResponse>, Array<number>>(
    "perfumes/fetchProductsByIdsQuery",
    async (ids) => {
        const response = await RequestService.post(PERFUMES_GRAPHQL_IDS, { query: geProductsByIdsQuery(ids) });
        return response.data.data.perfumesIds;
    }
);
