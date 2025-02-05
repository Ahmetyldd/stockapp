import { ProductsState } from "./perfumes-slice";
import { LoadingStatus, ProductResponse } from "../../types/types";
import { RootState } from "../../store";

export const selectProductsState = (state: RootState): ProductsState => state.perfumes;
export const selectProducts = (state: RootState): Array<ProductResponse> => selectProductsState(state).perfumes;
export const selectPagesCount = (state: RootState): number => selectProductsState(state).pagesCount;
export const selectTotalElements = (state: RootState): number => selectProductsState(state).totalElements;
export const selectIsProductsLoading = (state: RootState): boolean => selectProductsState(state).loadingState === LoadingStatus.LOADING;
