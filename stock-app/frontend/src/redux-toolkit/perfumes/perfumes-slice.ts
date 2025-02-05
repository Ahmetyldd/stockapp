import { createSlice, PayloadAction } from "@reduxjs/toolkit";

import { LoadingStatus, ProductResponse } from "../../types/types";
import {
    fetchProducts,
    fetchProductsByFilterParams,
    fetchProductsByIds,
    fetchProductsByIdsQuery,
    fetchProductsByInputText,
    fetchProductsByQuery
} from "./perfumes-thunks";

export interface ProductsState {
    perfumes: Array<ProductResponse>;
    pagesCount: number;
    totalElements: number;
    loadingState: LoadingStatus;
}

export const initialState: ProductsState = {
    perfumes: [],
    pagesCount: 1,
    totalElements: 0,
    loadingState: LoadingStatus.LOADING
};

export const perfumesSlice = createSlice({
    name: "perfumes",
    initialState,
    reducers: {
        setProducts(state, action: PayloadAction<Array<ProductResponse>>) {
            state.perfumes = action.payload;
            state.loadingState = LoadingStatus.LOADED;
        },
        removeProductById(state, action: PayloadAction<number>) {
            state.perfumes = state.perfumes.filter((perfume) => perfume.id !== action.payload);
            state.loadingState = LoadingStatus.LOADED;
        },
        resetProductsState: () => initialState
    },
    extraReducers: (builder) => {
        builder.addCase(fetchProducts.pending, (state) => {
            state.loadingState = LoadingStatus.LOADING;
        });
        builder.addCase(fetchProducts.fulfilled, (state, action) => {
            state.perfumes = action.payload.items;
            state.pagesCount = action.payload.pagesCount;
            state.totalElements = action.payload.totalElements;
            state.loadingState = LoadingStatus.LOADED;
        });
        builder.addCase(fetchProductsByIds.pending, (state) => {
            state.loadingState = LoadingStatus.LOADING;
        });
        builder.addCase(fetchProductsByIds.fulfilled, (state, action) => {
            state.perfumes = action.payload;
            state.loadingState = LoadingStatus.LOADED;
        });
        builder.addCase(fetchProductsByFilterParams.pending, (state) => {
            state.loadingState = LoadingStatus.LOADING;
        });
        builder.addCase(fetchProductsByFilterParams.fulfilled, (state, action) => {
            state.perfumes = action.payload.items;
            state.pagesCount = action.payload.pagesCount;
            state.totalElements = action.payload.totalElements;
            state.loadingState = LoadingStatus.LOADED;
        });
        builder.addCase(fetchProductsByInputText.pending, (state) => {
            state.loadingState = LoadingStatus.LOADING;
        });
        builder.addCase(fetchProductsByInputText.fulfilled, (state, action) => {
            state.perfumes = action.payload.items;
            state.pagesCount = action.payload.pagesCount;
            state.totalElements = action.payload.totalElements;
            state.loadingState = LoadingStatus.LOADED;
        });
        builder.addCase(fetchProductsByQuery.pending, (state) => {
            state.loadingState = LoadingStatus.LOADING;
        });
        builder.addCase(fetchProductsByQuery.fulfilled, (state, action) => {
            state.perfumes = action.payload;
            state.loadingState = LoadingStatus.LOADED;
        });
        builder.addCase(fetchProductsByIdsQuery.pending, (state) => {
            state.loadingState = LoadingStatus.LOADING;
        });
        builder.addCase(fetchProductsByIdsQuery.fulfilled, (state, action) => {
            state.perfumes = action.payload;
            state.loadingState = LoadingStatus.LOADED;
        });
    }
});

export const { setProducts, removeProductById, resetProductsState } = perfumesSlice.actions;
export default perfumesSlice.reducer;
